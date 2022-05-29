package com.example.esportapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.esportapi.R
import com.example.esportapi.databinding.FragmentEsportListBinding

class EsportListFragment: Fragment() {
    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEsportListBinding.inflate(inflater)
        viewModel.getGameList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = GameListAdapter(GameListener { game ->
            viewModel.onGameClicked(game)
            findNavController()
                .navigate(R.id.action_gameListFragment_to_gameDetailFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "Berita Esport Hari Ini"

        return binding.root
    }
}