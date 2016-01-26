package org.pujie.scala.`trait`

import scala.collection.mutable.ArrayBuffer

/**
 * trait的动态绑定
 * @author pujie
 */
object TraitTest extends App{
  val q1 = new BasicIntQueue with Incremening with Doubling
  q1.put(2)
  println(q1.get())
  val q2 = new BasicIntQueue with Doubling with Incremening
  q2.put(2)
  println(q2.get())
  val f3=(a:Int)=> a*2
}
abstract class IntQueue{
  def get():Int
  def put(x:Int)
}
class BasicIntQueue extends IntQueue{
  private val buf = new ArrayBuffer[Int]
  def get()=buf.remove(0)
  def put(x:Int){
    buf +=x
  }
}
trait Incremening extends IntQueue{
  abstract override def put(x:Int){
    super.put(x + 1)
  }
}
trait Doubling extends IntQueue{
  abstract override def put(x:Int){
    super.put(2 * x)
  }
}