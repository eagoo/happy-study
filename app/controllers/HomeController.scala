package controllers

import javax.inject._

import play.api._
import play.api.mvc._
import services.HanziToPinyin
import services.HanziToPinyin.Token

import scala.util.Random

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  val hanzi2pinyin = HanziToPinyin.getInstance()
  val r = Random
  def hello = Action {
    val book1 =
      """
        |鱼五爸妈我不里梨皮泥弟鸽肚河哗啦哈奇蜜机鸡马米了吐丝细做衣大是出的树丽世乌龟背晒太午睡黑猫狗底拍跳快油爷教姐写字说谢也船弯头尖坐见蓝天闪亮星挂放光明像许多山村一去二三烟四家亭台六七座八九十花人两宝双手和脑会事思考用情才能目口耳对小少高低粗空陆地下上短长炎热清凉日月水火金木土分照今古秋风谁瓣片吹落脱裳瓜果彩染得黄啊原它样朗行唐李白时识呼作玉盘又疑镜飞在青云端共
      """.stripMargin
    val idx = r.nextInt(book1.length)

    val c: String = book1.charAt(idx).toString
    import collection.JavaConverters._
    val p: String = hanzi2pinyin.get(c).asScala.map(t => if(t.`type` == Token.PINYIN) t.target else t.source).mkString(" ").toLowerCase()
    println(p)
    //Ok(c + )
    Ok(views.html.hello(c,p))
  }

}
