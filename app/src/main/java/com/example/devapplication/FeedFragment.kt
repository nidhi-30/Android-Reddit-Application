package com.example.devapplication

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.devapplication.adapters.FeedAdapter
import com.example.devapplication.databinding.FragmentFeedBinding
import com.example.devapplication.models.FeedDetail
import com.example.devapplication.network.FeedService
import com.example.devapplication.repositories.FeedRepository

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FeedFragment : Fragment(), FeedAdapter.OnItemClickListener{

    private var _binding: FragmentFeedBinding? = null

    lateinit var viewModel: FeedViewModel
    private val feedService = FeedService.getInstance()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var feedList : List<FeedDetail>? = null
    var feed_adapter = feedList?.let { FeedAdapter(it, this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.itemsswipetorefresh.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(view.context, R.color.red_200))
        binding.itemsswipetorefresh.setColorSchemeColors(Color.WHITE)
        binding.itemsswipetorefresh.setOnRefreshListener {
            Handler().postDelayed(Runnable {
                loadData()
                binding.itemsswipetorefresh.isRefreshing = false
            }, 2000)
        }

        viewModel = ViewModelProvider(this, FeedViewModelFactory(FeedRepository(feedService))).get(FeedViewModel::class.java)

        loadData()
        viewModel.getFeeds()
    }

    fun loadData(){
        feedList = null
        viewModel.feedList.observe(viewLifecycleOwner, Observer { response ->
            if(response != null){
                feedList = response
                feed_adapter = FeedAdapter(feedList!!, this)
                binding.listFeed.adapter = feed_adapter
//                Toast.makeText(this.context, "$feedList", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.error.observe(viewLifecycleOwner, Observer {

        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {
        val clickedFeed = feedList?.get(position)

        val feedFragment = FeedFragment()
        val bundle = Bundle()
        bundle.putParcelable("feed", clickedFeed)
        feedFragment.arguments = bundle

//        Toast.makeText(this.context, "$bundle", Toast.LENGTH_SHORT).show()

        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
    }

}