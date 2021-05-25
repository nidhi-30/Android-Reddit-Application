package com.example.devapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.devapplication.databinding.FragmentFeedDetailBinding
import com.example.devapplication.models.FeedDetail

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class FeedDetailFragment : Fragment() {

    private var _binding: FragmentFeedDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var args : FeedDetail? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFeedDetailBinding.inflate(inflater, container, false)

        val bundle = this.arguments
        if (bundle != null){
            args = bundle.getParcelable("feed")
        }

//        Toast.makeText(this.context, "$args", Toast.LENGTH_LONG).show()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imgUrl = args?.data?.url
        binding.author.text = args?.data?.author
        binding.title.text = args?.data?.title

        if(imgUrl != null) {
            Glide.with(view.context)
                .load(imgUrl)
                .override(250, 250)
                .error(R.drawable.ic_launcher_background)
                .into(binding.image)
        }
        else{
            binding.image.setImageResource(R.drawable.ic_launcher_background)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}