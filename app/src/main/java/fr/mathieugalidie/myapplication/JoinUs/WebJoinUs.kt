package fr.mathieugalidie.myapplication.JoinUs

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import fr.mathieugalidie.myapplication.R
import kotlinx.android.synthetic.main.join_us_web.*

class WebJoinUs : AppCompatActivity() {

   private val LOWPRICE : String= "\$30"
    private val SUSCRIPTION : String= "\$44"
    private val NO_SUSCRIPTION : String= "\$49"
    private var url = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       var  price : String = intent.getStringExtra("type_abonnement")

        if(price==LOWPRICE)
            url = "https://www.stuntculture.com.au/offers/n9uzZSV9/checkout"
        if(price == SUSCRIPTION )
            url = "https://www.stuntculture.com.au/offers/CgHqUcNw/checkout"
        if(price == NO_SUSCRIPTION)
            url = "https://www.stuntculture.com.au/offers/dcE29Q4b/checkout"

        setContentView(R.layout.join_us_web)
        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)
        val webSetting : WebSettings = webView.settings
        webSetting.javaScriptEnabled = true
        }

}