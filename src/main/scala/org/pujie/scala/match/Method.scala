package org.pujie.scala.`match`

/**
 * 递归函数
 * @author pujie
 */
object Method extends App{
  def mul(a:Int,b:Int):Int=a*b
  println(mul(2,2))
  //尾递归
  def fib(a:Long,b:Long,n:Long):Long = n match{
    case 0 =>b
    case _ => fib(b,a+b,n-1)
  }
  //递归
  def fib2(n:Int):Int= n match{
    case 0 => 0
    case 1 => 1
    case _ =>fib2(n-1) + fib2(n-2)
  }
  println(fib(0l,1l,50))
//  println(fib2(50))
  
}