package com.example.hw4.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieDrawable
import com.example.hw4.OnBoardingModel
import com.example.hw4.R
import com.example.hw4.databinding.ItemOnboardingBinding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val list = arrayListOf<OnBoardingModel>(
        OnBoardingModel(
            "Have a good time",
            "You should take the time to help those who need you",
            R.raw.love2
        ),
        OnBoardingModel(
            "Cherishing love",
            "It is no longer possible for you to cherish love",
            R.raw.love3
        ),
        OnBoardingModel(
            "Have a breakup?",
            "We have the correction for you don't worry \n mayby someone is waiting for you!",
            R.raw.love4
        ),
        OnBoardingModel("It's funs and many more!",
            "",
            R.raw.lovekiss)
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(onBoarding: OnBoardingModel) = with(binding) {
            tvTitle.text = onBoarding.title
            tvDesc.text = onBoarding.desc
            btnGetStarted.isVisible = adapterPosition == list.lastIndex

            onBoarding.lottieAnim?.let {
                ivBoard.setAnimation(onBoarding.lottieAnim)
                ivBoard.playAnimation()
            }


            btnGetStarted.setOnClickListener {
                onClick()
            }
        }
    }
}