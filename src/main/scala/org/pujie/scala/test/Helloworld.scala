package org.pujie.scala.test

/**
 * @author pujie
 */
class Helloworld {
  private val name = "hello"
  var addr = "world"
 
  def add(){
    println(name + " "+ addr);
  }
  def plus(m:Char)=addr + m
}

object Helloworld{
  def main(args: Array[String]) { 
    val h = new Helloworld();
    h.add()
    println(h.plus('a'))
  }
}