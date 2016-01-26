package org.pujie.scala.test

/**
 * @author pujie
 */
abstract class Sun1 {
  val name:Array[String] //抽象的val，带有一个抽象的getter方法
  var num:Int            //抽象的var，带有抽象的getter/setter方法
  def sign              //没有方法体  的抽象方法
}