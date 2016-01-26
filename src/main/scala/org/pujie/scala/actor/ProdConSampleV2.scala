package org.pujie.scala.actor
/**
 * producer/consumer模式
 * 利用scala的MailBox
 * @author pujie
 */
object ProdConSampleV2 {
  
  class Drop{
    private case class Empty()
    private case class Full(x:String)
    
    
  }
}