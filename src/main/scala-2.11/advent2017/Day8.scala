package advent2017

import advent2017.Utils._

case class Variable(name: String, value: Int)
case class Operation(operation: String, operand: Int)
case class Instruction(variable: String, operation: Operation, condition: Condition)

case class Condition(variable: String, operation: String, value: Int) {
  def res(registers: Map[String, Int]): Boolean = {
    val varValue = registers(variable)
    operation match {
      case ">" => varValue > value
      case "<" => varValue < value
      case ">=" => varValue >= value
      case "<=" => varValue <= value
      case "!=" => varValue != value
      case "==" => varValue == value
    }
  }
}

object Expression {

  def performOperation(op: Operation, value: Int): Int = {
    op.operation match {
      case "inc" => op.operand + value
      case "dec" => value - op.operand
    }
  }

  def eval(ins: List[Instruction], registers: Map[String, Int]): Map[String, Int] = {
    ins match {
      case Nil => registers
      case h :: t =>
        if(h.condition.res(registers)) {
          val updatedReg = registers.updated(h.variable, performOperation(h.operation, registers(h.variable)))
          eval(t, updatedReg)
        }
        else
          eval(t, registers)
    }
  }

  def evalInstructions(records: List[String]): Int = {
    val instructions = records.map { r =>
      val ts = r.split(" ")
      val variable = ts(0)
      val operation = Operation(ts(1), ts(2).toInt)
      val condition = Condition(ts(4), ts(5), ts(6).toInt)

      Instruction(variable, operation, condition)
    }
    val registers = instructions.map(ins => (ins.variable -> 0)).toMap
    val updatedReg = eval(instructions, registers)
    updatedReg.values.max
  }
}

object Day8 extends App {

  val lines = getInput("/advent2017/day8.txt")

  val res = Expression.evalInstructions(lines)
  println(res)

}
