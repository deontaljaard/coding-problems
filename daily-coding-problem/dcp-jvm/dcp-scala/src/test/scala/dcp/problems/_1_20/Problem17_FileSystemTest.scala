package dcp.problems._1_20

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem17_FileSystemTest extends AnyFlatSpecLike with Matchers {

  "FileSystem" should "should return length of longest absolute path" in {
    val fs1 = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
    val fs2 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
    val fs3 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\t\t\tsubsubsubdir1\n\t\t\t\tfile2.ext\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile3.ext"

    Problem17_FileSystem.parse(fs1) should be (20) // dir/subdir2/file.ext
    Problem17_FileSystem.parse(fs2) should be (32) // dir/subdir2/subsubdir2/file2.ext
    Problem17_FileSystem.parse(fs3) should be (46) // dir/subdir1/subsubdir1/subsubsubdir1/file2.ext
  }

}
