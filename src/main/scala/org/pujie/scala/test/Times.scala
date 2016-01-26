package org.pujie.scala.test

import com.sun.istack.internal.NotNull

/**
 * @author pujie
 */
class Times {
   var hours=0
   var minutes:Int=0
   val times:String=""
   
   def this( h:Int,m:Int){
     this()
     this.hours = h
     this.minutes = m
   }
   def check(@NotNull pw:String){
     
   }
   def get()={
     println(hours + ":" +minutes)
   }
   def dos(){
     if(hours >= 24)
       hours = 0
     else
       hours += 1
     if(minutes >=60)
       minutes = 0
     else
       minutes += 1
   }
}
object Times{
  def main(args:Array[String]){
    var t = new Times(12,5)
    t.get()
    t.dos()
    t.dos()
    t.get()
  }
}