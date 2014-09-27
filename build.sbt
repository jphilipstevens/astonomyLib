name := "AstroLib"

version := "1.0"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.pegdown" % "pegdown" % "1.4.2" % "test"
)

testOptions in ThisBuild += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")


instrumentSettings