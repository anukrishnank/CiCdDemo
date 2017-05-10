package com.au.mylearning.scalding

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.WordSpec
import org.scalatest.Matchers
import com.twitter.scalding.JobTest
import com.twitter.scalding.TypedTsv

@RunWith(classOf[JUnitRunner])
class TypedUniqueProductTest extends WordSpec with Matchers {
  "output result" should {
    JobTest[TypedUniqueProducts]
      .arg("output", "outputFile")
      .sink[(Long, Long)](TypedTsv[(Long, Long)]("outputFile")){buff =>
      val outMap = buff.toMap
      "contains the values " in {
        outMap(1) shouldBe 3
        outMap(2) shouldBe 1
      }
    }
      .run
      .finish
  }
}
