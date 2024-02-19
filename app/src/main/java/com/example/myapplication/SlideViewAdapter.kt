package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class SlideViewAdapter(private val ctx: Context) : PagerAdapter() {

    override fun getCount(): Int {
        return 3
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = layoutInflater.inflate(R.layout.slide_screen, container, false)

        val logo = view.findViewById<ImageView>(R.id.logo)
        val ind1 = view.findViewById<ImageView>(R.id.ind1)
        val ind2 = view.findViewById<ImageView>(R.id.ind2)
        val ind3 = view.findViewById<ImageView>(R.id.ind3)
        val title = view.findViewById<TextView>(R.id.title)
        val desc = view.findViewById<TextView>(R.id.desc)
        val next = view.findViewById<ImageView>(R.id.next)
        val back = view.findViewById<ImageView>(R.id.back)
        val btnGetStarted = view.findViewById<ImageButton>(R.id.btnStart)

        btnGetStarted.setOnClickListener {
            val intent = Intent(ctx, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            ctx.startActivity(intent)
        }

        next.setOnClickListener {
            // Here, I assumed that viewPager is a property of SlideActivity. If not, you need to pass it to SlideViewAdapter constructor.
            (ctx as SlideActivity).viewPager?.setCurrentItem(position + 1, true)
        }

        back.setOnClickListener {
            (ctx as SlideActivity).viewPager?.setCurrentItem(position - 1, true)
        }

        when (position) {
            0 -> {
                logo.setImageResource(R.drawable.selected)
                ind1.setImageResource(R.drawable.selected)
                ind2.setImageResource(R.drawable.unselected)
                ind3.setImageResource(R.drawable.unselected)
                title.text = "Shopping Place"
                desc.text = "This is random text taken from lorem ipsum for testing purpose"
                back.visibility = View.GONE
                next.visibility = View.VISIBLE
            }
            1 -> {
                logo.setImageResource(R.drawable.logo2)
                ind1.setImageResource(R.drawable.unselected)
                ind2.setImageResource(R.drawable.selected)
                ind3.setImageResource(R.drawable.unselected)
                title.text = "Shopping on the way"
                desc.text = "This is random text taken from lorem ipsum for testing purpose"
                back.visibility = View.VISIBLE
                next.visibility = View.VISIBLE
            }
            2 -> {
                logo.setImageResource(R.drawable.logo3)
                ind1.setImageResource(R.drawable.unselected)
                ind2.setImageResource(R.drawable.unselected)
                ind3.setImageResource(R.drawable.selected)
                title.text = "Pay on Delivery"
                desc.text = "This is random text taken from lorem ipsum for testing purpose"
                back.visibility = View.VISIBLE
                next.visibility = View.GONE
            }
        }

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
