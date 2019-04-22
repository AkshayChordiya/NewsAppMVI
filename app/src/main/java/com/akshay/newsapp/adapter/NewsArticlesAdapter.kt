package com.akshay.newsapp.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akshay.newsapp.R
import com.akshay.newsapp.domain.Article
import com.akshay.newsapp.utils.inflate
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.row_news_article.view.*

/**
 * The News adapter to show list of news.
 */
class NewsArticlesAdapter(
    private val listener: (Article) -> Unit
) : RecyclerView.Adapter<NewsArticlesAdapter.NewsHolder>() {

    /**
     * List of news articles
     */
    private var newsArticles: List<Article> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsHolder(parent.inflate(R.layout.row_news_article))

    override fun onBindViewHolder(newsHolder: NewsHolder, position: Int) =
        newsHolder.bind(newsArticles[position], listener)

    override fun getItemCount() = newsArticles.size

    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(newsArticle: Article, listener: (Article) -> Unit) = with(itemView) {
            tvNewsItemTitle.text = newsArticle.title
            tvNewsAuthor.text = newsArticle.author
            //TODO: need to format date
            //tvListItemDateTime.text = getFormattedDate(newsArticle.publishedAt)
            tvListItemDateTime.text = newsArticle.publishedAt
            Glide.with(context)
                .load(newsArticle.urlToImage)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.img_test_one)
                        .error(R.drawable.img_test_one)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(ivNewsImage)
            setOnClickListener { listener(newsArticle) }
        }

    }

    /**
     * Swap with new data set and update the UI
     */
    fun replaceItems(items: List<Article>) {
        newsArticles = items
        notifyDataSetChanged()
    }
}