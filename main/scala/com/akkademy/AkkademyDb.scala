package com.akkademy

import akka.actor.Actor
import akka.event.Logging
import com.akkademy.messages.SetRequest

import scala.collection.mutable

class AkkademyDb extends Actor{
  val map = new mutable.HashMap[String, Object]
  val Log = Logging(context.system, this)
  override def receive = {
    case Some(SetRequest(key,value) )=> {map.put(key, value)
      Log.info("received key: {} and value: {}", key,value)
    }
    case o =>  Log.info("received unknown message: {}", o)
  }
}
