package org.pujie.scala.func

/**
 * @author pujie
 * fold/foldLeft/foldRight测试
 */
object Fold {
  val list = (1 to 100)
  val fooList = List(Foo(1,"关羽",32,'male),
                     Foo(2,"张飞",30,'male),
                     Foo(3,"赵云",29,'male),
                     Foo(4,"孙尚香",22,'female),
                     Foo(5,"大乔",24,'female),
                     Foo(6,"小乔",20,'female))
  def main(args:Array[String]){
    
    val sum = (1 to 100).fold(0)((p,n)=>p+n)
    println("求和："+sum)
    
    val fooListFoldLeft = fooList.foldLeft(List[String]())(fooLeft)
    
    val foolListRight = fooList.foldRight(List[String]()){
      (i,b) =>
        val title = i.sex match {
          case 'male => "Mr."
          case 'female => "Ms."
        }
        b :+ s"NO.${i.id} ${title}${i.name},${i.age}"
    }
    
    val fooListFold = fooList.fold(Foo(0,"刘备",35,'male)){
      (i,b) =>
        val title = i.sex match{
          case 'male => "Mr."
          case 'female => "Ms."
        }
        println(s"${i.id} $title${i.name} ${i.age}; ${b.id} $title${b.name} ${b.age}")
        Foo(b.id,title+b.name,b.age,b.sex)
    }

    
    println("**foldLeft**:")
    fooListFoldLeft.foreach { x => println(x) }
    println("**foldRight**:")
    foolListRight.foreach { x => println(x) }
    println("*******************************")
    val t = fooList.fold(List[Foo]()){
      (i,b) =>
        println(i +" " + b)
        List[Foo]()
    }
      
  }
  /**
   * FooList 做foldLeft处理
   */
  def fooLeft(list:List[String],foo:Foo):List[String] = {
    val title = foo.sex match {
      case 'male => "Mr."
      case 'female => "Ms."
    }
    list :+ s"NO.${foo.id} ${title}${foo.name},${foo.age}"
  }
  
}

class Foo(val id:Int,val name:String,val age:Int,val sex:Symbol)
object Foo {
  def apply(id:Int,name:String,age:Int,sex:Symbol) = new Foo(id,name,age,sex)
}