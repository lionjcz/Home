package com.company.maxe.Login.index_menu.hr.ActivityImg.DisplayImageFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jekma.maxe.R

class displayimagefragment : Fragment() {
    //    private static final String ARG_PARAM1 = "param1";
    //    private static final String ARG_PARAM2 = "param2";
    //
    //    private String mParam1;
    //    private String mParam2;
    //    private OnFragmentInteractionListener mListener;
    //    public displayimagefragment() {
    //        // Required empty public constructor
    //    }
    //
    //
    //    public static displayimagefragment newInstance(String param1, String param2) {
    //        displayimagefragment fragment = new displayimagefragment();
    //        Bundle args = new Bundle();
    //        args.putString(ARG_PARAM1, param1);
    //        args.putString(ARG_PARAM2, param2);
    //        fragment.setArguments(args);
    //        return fragment;
    //    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.maxe_fragment_displayimagefragment, container, false)
    } //    public void onButtonPressed(Uri uri) {
    //        if (mListener != null) {
    //            mListener.onFragmentInteraction(uri);
    //        }
    //    }
    //
    //    @Override
    //    public void onAttach(Context context) {
    //        super.onAttach(context);
    //        if (context instanceof OnFragmentInteractionListener) {
    //            mListener = (OnFragmentInteractionListener) context;
    //        } else {
    //            throw new RuntimeException(context.toString()
    //                    + " must implement OnFragmentInteractionListener");
    //        }
    //    }
    //
    //    @Override
    //    public void onDetach() {
    //        super.onDetach();
    //        mListener = null;
    //    }
    //
    //    public interface OnFragmentInteractionListener {
    //        void onFragmentInteraction(Uri uri);
    //    }
}