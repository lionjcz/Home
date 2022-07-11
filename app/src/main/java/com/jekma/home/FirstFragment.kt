package com.jekma.home

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.jekma.baselibrary.BaseFragment
import com.squareup.picasso.Picasso

class FirstFragment : BaseFragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }

    override val titleResId: Int
        get() = R.string.title_first
    override val layoutResId: Int
        get() = R.layout.fragment_first

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        showLoading(true, gif = "https://lh3.googleusercontent.com/RN2vkLO2ZMKoE08l5IybfcrSnqaaj2WCQxSlItaoneMv_Irkt8sVVotw48Tyu7Dz7B3wi415hVo-Z8QzxsPm_FDrdc63Eu9pzvebYVFfCfuA_39PVcbIWXACrTsiCMUaIUAGPCteOnWvCNCpVk4Cg-jsYS43gWi0vTYHl0ytlz-H3pURnGrreCNB1Grlgs_4SoCWi7M3bQXSoLQ-DeTMBc-0NWx3I0RcwCE3b_MzOqcHT4T9ClK-6ZnTArcKj3yPVqhZHpwODde1026B6ylLuDby7PhpBm3-nyZlEwze1mi7q10kDp1k4o3WW7AcVuMkYBFe7aIVuz_fDLsZmSxYFS3KFGiAYqtMfD1Cwt4Wx65ICQB9rmgj9Z_oZDmt3NJPXb2Rw-L2fu_Uyp7OwAjnxGKT1kYqEsW1StAubbassU_wbYzrDGIeIoku-42m8WvZWU4J8TBjoBc8Uul1dVNQ1TIv65xJlwDi-GiC8-DQpZSC5att-Kq5RHGj1SvMt0na1q5UPgrsw7CTw4iuiFNnm158HP70c14fNMONj926s30FPOtuztqoUBgPragG1XUIsUQeMzvVATnJsvCh9o1leBqfk4zERuD0oezhuYGbprFguF_chZwIVq77xC9YuQKWg9WM7v1y6xAbnX3yNQVNL2cDM_qkKwi_3kRojAOhwPlsrXBgpNYRmQB31XlOznD05G_7pW5CUIA-vU6dQpBuVixBWOCe2DIfbJ4PKcZwJnSivkVUDyUYLGRWpBfOGvo=w554-h737-no?authuser=0")
        showLoading(true, gif = R.drawable.progress)

//        val imageUrl = "https://media3.giphy.com/media/xTiTnet7xRv1GPTShi/giphy.gif?cid=790b7611e5dd78d09cb6f4a6d76e97644d45f0b5fe71f08b&rid=giphy.gif&ct=g"
        val imageview = view.findViewById<ImageView>(R.id.iv1234)
        imageview.alpha = 0.5f;
        Glide.with(this).load(R.drawable.progress).into(imageview)
//        Picasso.with(requireContext()).load(imageUrl).into(imageview)
    }

}