package Calculator

import collection.mutable



object Calc{
  val stack = new mutable.Stack[Double]


  def push(num:Double) = stack.push(num)

  def op(op:Char):Option[Double] = {
    try{
      val num2 = stack.pop()
      val num1 = stack.pop()


      var result:Double = 0
      op match{
        case '+' =>
          result=num1+num2
          push(result)
          Some(result)
        case '*' =>
          result=num1*num2
          push(result)
          Some(result)
        case '-' =>
          result=num1-num2
          push(result)
          Some(result)
        case '/' =>
          result=num1/num2
          push(result)
          Some(result)
        case _ => None
      }
    }
    catch{
      case e: NoSuchElementException => {
        println("Faltam números na stack para fazer a operação!")
        None
      }
      case _: Exception =>{
        println("Erro desconhecido!")
        None
      }
    }
  }

  def clean(){
    while(!stack.isEmpty){
      stack.pop()
    }
  }
}
