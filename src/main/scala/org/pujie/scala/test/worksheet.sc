package org.pujie.scala.test

object worksheet {
  println("Welcome to the Scala worksheet")
  def bar(s:String,n:Int):Unit= for(i <- 1 to n)print(s)
  //直接使用匿名函数
  ((s:String) => s.length())("hello world!")
  //把函数赋值给 常量
  val sizes = (s:String) => s.length()
  //利用变量调用函数
  sizes("hello world!")
  //偏函数，case以外的输入，会抛出MatchError异常
  def pf:Symbol => Int = {
  	case 'a => 97
  	case 'b => 98
  	case 'c => 99
  }
  pf('a)
  
  def f2:PartialFunction[Symbol,Int] = {
  	case 'a => 97
  	case 'b => 98
  	case 'c => 99
  }
  
  for(e <- List('a,'b,'c,'d)){
  	if( f2.isDefinedAt(e) ) println(f2(e))
  }
  def bar2(s:String,n:Int):Unit ={ 1 to n foreach{ i=> print(s)} }
 	val list = List("scala","is","functional","language")
 	list.foreach{ e => print(e+",") }
 	list.map(s => s+" ")
}