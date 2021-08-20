import scala.annotation.varargs

object accountobj extends App{

    var bank:List[Account]=List(new Account("a1",123,17000.50),new Account("a2",124,-15000.70),new Account("a3",125,20200.00),new Account("a4",126,-5950.00), new Account("a4",126,-9000.00),new Account("a5",127,5600))
    def isNegative=(l:Account)=>l.balance<0
    def negativeBalance=bank.filter(isNegative)
    println(s"Account list with negative balance : $negativeBalance")

    def balance = (l:Account)=>l.balance
    var totalBalance = bank.map(balance).reduce((x,y)=>(x+y))
    println(s"Total balance = $totalBalance")

    val interest=(l:Account)=>if (l.balance<0) l.balance=l.balance-l.balance*0.1/100 else l.balance=l.balance+l.balance*0.05/100
    bank.map(interest)
    println(s"After calculating the interest=$bank")
    
    

}
class  Account(id:String,n:Int,b:Double){
    var nic:String=id
    var acnumber:Int=n
    var balance:Double=b

    override def toString="["+nic+":"+acnumber+":"+balance+"]"

    def withdraw(a:Double){
        this.balance=this.balance-a
    }

    def deposit(a:Double){
        this.balance=this.balance+a
    }

    def transfer(a:Account,b:Double){
        a.deposit(b)
        this.withdraw(b)
    }

    
}