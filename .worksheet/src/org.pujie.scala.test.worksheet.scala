package org.pujie.scala.test

object worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(92); 
  println("Welcome to the Scala worksheet");$skip(57); 
  def bar(s:String,n:Int):Unit= for(i <- 1 to n)print(s);System.out.println("""bar: (s: String, n: Int)Unit""");$skip(58); val res$0 = 
  //直接使用匿名函数
  ((s:String) => s.length())("hello world!");System.out.println("""res0: Int = """ + $show(res$0));$skip(53); 
  //把函数赋值给 常量
  val sizes = (s:String) => s.length();System.out.println("""sizes  : String => Int = """ + $show(sizes ));$skip(37); val res$1 = 
  //利用变量调用函数
  sizes("hello world!");System.out.println("""res1: Int = """ + $show(res$1));$skip(116); 
  //偏函数，case以外的输入，会抛出MatchError异常
  def pf:Symbol => Int = {
  	case 'a => 97
  	case 'b => 98
  	case 'c => 99
  };System.out.println("""pf: => Symbol => Int""");$skip(9); val res$2 = 
  pf('a);System.out.println("""res2: Int = """ + $show(res$2));$skip(99); 
  
  def f2:PartialFunction[Symbol,Int] = {
  	case 'a => 97
  	case 'b => 98
  	case 'c => 99
  };System.out.println("""f2: => PartialFunction[Symbol,Int]""");$skip(76); 
  
  for(e <- List('a,'b,'c,'d)){
  	if( f2.isDefinedAt(e) ) println(f2(e))
  };$skip(71); 
  def bar2(s:String,n:Int):Unit ={ 1 to n foreach{ i=> print(s)} };System.out.println("""bar2: (s: String, n: Int)Unit""");$skip(56); 
 	val list = List("scala","is","functional","language");System.out.println("""list  : List[String] = """ + $show(list ));$skip(36); 
 	list.foreach{ e => print(e+",") };$skip(23); val res$3 = 
 	list.map(s => s+" ");System.out.println("""res3: List[String] = """ + $show(res$3))}
}
