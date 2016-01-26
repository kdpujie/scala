package org.pujie.scala.`match`

/**
 * 模式匹配/样例类
 * @author pujie
 */
object PatternMatch extends App {
  //模式匹配
  def patternMatch(){
    val hi = Array("hi","hello","world","!")
    hi match{
    case Array("hi",_) => println("OK")
    case Array("hi","hello",_*) => println("Wrong")
    case _ => println("None")
    }
  }
//  patternMatch()
  val x = Var("name of x")
  println("1,case class生成一个同名的对象构造器，可用Var('x')直接定义对象："+x)
  val binOp = BinOp("+",Number(1),x)
  println("2,同名构造器方便嵌套结构："+binOp)
  println("3,case class以构造参数创建 同名属性：x.name="+x.name)
  println("4,binOp右边参数是否和x相等："+(binOp.right == x))
  //模式匹配
  def simplifyTop(expr:Expr) = expr match{
    case UnOp("-",UnOp("-",e)) =>e
    case BinOp("+",e,Number(0)) =>"0 + e"
    case BinOp("*",e,Number(1)) =>"e * 1"
    case BinOp("=",x,y)if x == y => "x = y" //模式守卫，只有if返回true时，模式匹配成功。
    case _ => expr
  }
  println(simplifyTop(BinOp("=",Var("1"),Var("1"))))
  var S=0
  val aa = S match{
    case 0 => "0"
    case 1 => "1"
    case _ => "default"
  }
  println(aa)
  def generalSize(x : Any) = x match{
   case s : String => s.length
   case m : Map[_, _] => m.size
   case _ => 1
 }
  
}
/**
 * case class 样例类
 */
abstract class Expr
case class Var(name:String) extends Expr
case class Number(num:Double) extends Expr
case class UnOp(operator:String,arg:Expr) extends Expr
case class BinOp(operator:String,left:Expr,right:Expr) extends Expr
