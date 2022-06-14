package com.example.assignment2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment2.Model.Post
import com.example.assignment2.adapter.PostAdapter
import com.example.assignment2.api.RetrofitAPI
import com.google.android.material.snackbar.Snackbar
import com.example.assignment2.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.navigation.fragment.findNavController


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val retrofitAPI = RetrofitAPI.create()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        val post = retrofitAPI.getpostswithComments()

        post.enqueue(object : Callback<List<Post>>){
            override   fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>){
            val postbody = response.body()
            val adapter= PostAdapter(postbody!!,this,{position -> onListItemClick (position) })
            binding.recyclerView.adapter = adapter
        }
            override   fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Snackbar.make(view,"Failure in CallBack", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                Log.i("TAG", "onFailure : Callback failed")
            }
            }
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onListItemClick(position : Int){
        Snackbar.make(requireView(),"Clicked on item ${position+1}", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
        Log.i("TAG", "onFailure : Callback failed")
    }
}