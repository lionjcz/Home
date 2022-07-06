package com.jekma.home

import android.os.Bundle
import android.view.View
import android.widget.ImageView
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
        val imageUrl = "https://lh3.googleusercontent.com/jLTcYhNzACCDAfjGS6DlIat4gc0fkwvxF6I6ufak0_vtXlAQZcpDrLoaLC2ZoYzMT5WS1O1hGnDAAZBnS6o-o6ro1lyFha5p995-LJ1MKYC3OPeVKtVqjjsLpHJ2i_rkaDCXmpfRLXNDvZYstBK5sJVZ6ve9P8EWczSwovKJFN36WJV98aLFO-kZisHfU73ajuptYPjk_6t9Hb2fRGWw6CXNYDFdk5RGGvuFcIyOjO1ywOJgHAQ9JXZrUis9HfJGMH9XE5qY-GS7C115UuLQjGadhR12J32hvep0DxCmOcmbpCBK9-2oP4QNsyLdnBa1eykCKaij7GXjb3wv3y7_dhqWBmRp7NcylN5jFSbqkpNsV4yCi5UCK9XYXLzjK8bXpBV5Y514RfYyyvnSl4lq1Fm6HkVcV3hwA39jXrdkbYoWGghywDCvNUB455hTFnM-MZiityDYs2BDNRkpiC0LSX059YK6r_UZFfo_OEdimehQEIMuS8w5VUQ93omr2y-dWJAal-s6hl4IJ88xWTlS_WuLtihiL2FORnptBKTn_p8YXdVtoq1ru-Yn8pKykorcXIMcfB4eNFvsRqIqbKDtIvx_pZ8GyvKNDC_kP45S3-O-xQYW5qdFDckRj_rpUlDUoQBFqYD1LwWbTekgw6KfCB8_J3t8H7HOZwAMtkX8LCBgjFSNKMYlzpR4aBVjUrRLkWbydJUJdnYccRkBNWqVqEO2dikuCdtVIraNg1_jq24sZDeNHWmGbiPfRotaBNM=w497-h881-no?authuser=0"
        val imageview = view.findViewById<ImageView>(R.id.iv1234)
        imageview.alpha = 0.5f;
        Picasso.with(requireContext()).load(imageUrl).into(imageview)
    }

}