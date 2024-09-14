package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BalanceSuite extends FunSuite {
  import Main.balance

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("balance: 'I told him ...' is balanced") {
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
  }

  test("balance: ':-)' is unbalanced") {
    assert(!balance(":-)".toList))
  }

  test("balance: counting is not enough") {
    assert(!balance("())(".toList))
  }

  test("balance: test 1") {
    assert(!balance(")".toList))
  }

  test("balance: test 2") {
    assert(balance("hello".toList))
  }

  test("balance: test 3") {
    assert(!balance(")(".toList))
  }

  test("balance: test 4") {
    assert(!balance("(((()))".toList))
  }

  test("balance: test 5") {
    assert(balance("()(())".toList))
  }
}
