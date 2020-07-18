package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.data.vos.NewsVO
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.delegates.NewsItemDelegate
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewpods.ReactionViewPods
import kotlinx.android.synthetic.main.item_news.view.*
import kotlinx.android.synthetic.main.item_news.view.ivNewsImage
import kotlinx.android.synthetic.main.item_news.view.tvNewsHeadLine
import kotlinx.android.synthetic.main.item_news.view.viewPodReaction
import kotlinx.android.synthetic.main.item_news_smalll.view.*

/**
 * Created by Ye Pyae Sone Tun
 * on 2020-01-18.
 */

class NewsViewHolder(itemView: View,private val delegate: NewsItemDelegate) :
  BaseNewsViewHolder(itemView) {

    private val mViewPodReaction = itemView.viewPodReaction as ReactionViewPods

    init {

        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapNewsItem(it.id)
            }
        }
    }

    override fun bindData(data: NewsVO) {
        mData = data
        Glide.with(itemView.context)
            .load(data.heroImage)
            .into(itemView.ivNewsImage)
        itemView.tvNewsHeadLine.text = data.title

        mViewPodReaction.bindData(data)
        mViewPodReaction.setDelegate(delegate)
    }




}