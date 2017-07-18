package day17

import day14.Utils

/**
  * Created by doctorq on 2017/7/10.
  * https://leetcode.com/problems/add-two-numbers/#/description
  */
object LeetCode2 extends Utils with App {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var firstNode = l1
    var secondNode = l2
    var resultNode: ListNode = null
    var temp: ListNode = null
    var more: Boolean = false
    while (firstNode != null || secondNode != null) {
      val addNum = if (secondNode == null) {
        val result = firstNode._x
        firstNode = firstNode.next
        result
      } else if (firstNode == null) {
        val result = secondNode._x
        secondNode = secondNode.next
        result
      } else {
        val result = firstNode._x + secondNode._x
        firstNode = firstNode.next
        secondNode = secondNode.next
        result
      }
      val _x = if (more) {
        more = false
        addNum % 10 + 1
      } else {
        addNum % 10
      }
      if (addNum >= 10 || _x >= 10) {
        more = true
      }

      if (resultNode == null) {
        resultNode = new ListNode(_x % 10)
        temp = resultNode
      } else {
        temp.next = new ListNode(_x % 10)
        temp = temp.next
      }

    }
    if (more) {
      temp.next = new ListNode(1)
    }
    resultNode
  }

  def createNode(digit: Int): ListNode = {
    var temp = digit
    val value = temp % 10
    val root = new ListNode(value)
    temp /= 10
    var tempNode = root
    while (temp > 0) {
      tempNode.next = new ListNode(temp % 10)
      tempNode = tempNode.next
      temp /= 10
    }
    root
  }


  val num1 = 1
  val num2 = 99
  val l1 = createNode(num1)
  val l2 = createNode(num2)
  val result = addTwoNumbers(l1, l2)

  var resultNode = result
  while (resultNode != null) {
    println(resultNode._x)
    resultNode = resultNode.next
  }

}

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

