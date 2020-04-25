package dcp.problems._21_40

import dcp.problems._21_40.Problem36_SecondLargestNode.Tree
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem36_SecondLargestNodeTest extends AnyFlatSpecLike with Matchers {

  "SecondLargestNode" should "should find second largest node in BST" in {
    /*       BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
    val secondLargest = Tree(70,
      left = Tree(60),
      right = Tree(80)
    )

    val bst = Tree(50,
      left = Tree(30,
        left = Tree(20),
        right = Tree(40)),
      right = secondLargest
    )

    Problem36_SecondLargestNode.find2ndLargestN(bst) should be (secondLargest)
  }

}
