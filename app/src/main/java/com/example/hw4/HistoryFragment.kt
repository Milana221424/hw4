package com.example.hw4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.hw4.data.room.LoveDao
import com.example.hw4.databinding.FragmentHistoryBinding
import com.example.hw4.remote.LoveModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : Fragment() {
    @Inject
    lateinit var dao: LoveDao
    private val viewModel: LoveViewModel by viewModels()
    private lateinit var binding: FragmentHistoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getGetDao().observe(viewLifecycleOwner, Observer {loveModelList ->
            val list = mutableListOf<LoveModel>()
            loveModelList?.let { list.add(it) }

            binding.tvListHistory.text =list.joinToString(
                separator = "\n",
                transform = { it.toString() },
                prefix = "",
                postfix = ""
            )
                /*list.joinToString(separator = "", prefix = "", postfix = "")*/
        })
       /* val list = dao.getAll()

        list.forEach {
            binding.tvListHistory.text =
                list.joinToString(separator = "", prefix = "", postfix = "")
        }*/
    }
}
/* viewModel.getLiveLoveData(etFirstName.text.toString(), etSecondName.text.toString())
                    .observe(viewLifecycleOwner, Observer {
                        tvResult.text = it.toString()
                    })*/