package org.pujie.scala.actor

/**
 * 类似 java 的 producer/consumer模式
 * 和java相比，仍然存在相同的基本问题：程序员仍然需要过分担心两个线程之间的通信和协调问题。
 * 虽然一些 Scala 机制可以简化语法，但这目前为止并没有相当大的吸引力。
 * @author pujie
 */
object ProdConSample {
  /**
   * 相当于生产/消费 共享队列
   */
  class Drop{
    var message:String = ""
    var empty:Boolean = true
    var lock:AnyRef = new Object()
    
    private def await(cond:Boolean)={
      if(cond)
        lock.wait()
    }
    def put(x:String):Unit=
      lock.synchronized
    {
      await(!empty)
      empty = false
      message = x
      lock.notifyAll();
    }
    def take():String=
      lock.synchronized
    {
      await(empty)
      empty = true;
      lock.notifyAll()
      message
    }
  }
  /**
   * 生产者
   */
  class Producer(drop:Drop) extends Runnable{
    val importantInfo:Array[String] = Array(
      "Mares eat oats",
      "Does eat oats",
      "Little lambs eat ivy",
      "A kid will eat ivy too"
    );
    override def run():Unit={
      importantInfo.foreach { msg => drop.put(msg) }
      drop.put("Done")
    }
  }
  /**
   * 消费者
   */
  class Consumer(drop:Drop) extends Runnable{
    override def run():Unit = {
      var msg = drop.take();
      while(msg != "Done"){
        System.out.format("Message received:%s%n", msg);
        msg = drop.take();
      }
    }
  }
  
  def main(args:Array[String]):Unit={
    // create Drop
    val drop = new Drop()
    //spawn producer
    new Thread(new Producer(drop)).start()
    //spawn consumer
    new Thread(new Consumer(drop)).start()
  }
}