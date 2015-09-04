import Chisel._

class PwmModule(c: Clock = null) extends Module(c) {
  val io = new Bundle {
        /* parameters */
        val enable = Bool(INPUT)
        /* output */
        val pwmout = Bool(OUTPUT)
  }

  io.pwmout := io.enable
}

class PwmTests(c: PwmModule) extends Tester(c) {
  step(1)
}

object pwm {
  def main(args: Array[String]): Unit = {
    chiselMainTest(Array[String]("--backend", "c", "--compile", "--test", "--genHarness"),
       () => Module(new PwmModule())){c => new PwmTests(c)}
  }
}
