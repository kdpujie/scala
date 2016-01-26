package org.pujie.scala.test

/**
 * @author pujie
 */
class parent {
  val one=25      //可在子类中重写
  var two=15      //不可在子类中用var重写，因为是不是抽象的
  def firstday={}  //可在子类中用val重写
  def now = {}     //可在子类中用var重写
  def now_={}
  def lastday(m:Char)={}  //可在子类中用def重写
}