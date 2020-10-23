package com.example.adoption.Fragrnents;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adoption.Clinics;
import com.example.adoption.ClinicsAdapter;
import com.example.adoption.R;
import com.example.adoption.Tips;
import com.example.adoption.TipsAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFragment extends Fragment {

    View view;
//    TextView textView;

    public TipsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_call, container, false);
//        textView= view.findViewById(R.id.CallTxt);
//        textView.setText("Call Fragment");

        view= inflater.inflate(R.layout.fragment_school, container, false);

        RecyclerView recyclerView= view.findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(lm);

//        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(),DividerItemDecoration.VERTICAL));

        ArrayList<Tips> tips = new ArrayList<>();
        Tips t1 = new Tips( "السماح للقطة بتجربة أسطح المشي المختلفة، ومنها الأغطيّة الشمعيّة، والسجاد، وغيرها عندما تبدأ بالوقوف والمشي.\n\n\n اصطحاب القطة للخارج بحملها يدويّاً، وتعريضها للهواء الطلق بعد التحقق من إعطائها اللقاحات والمطاعيم الطبيّة التي تحتاجها؛ لحمايتها من الأمراض.\n\n\n تقديم بعض الأشياء والوسائل التي تُساعد القطة على الحركة والاكتشاف مثل: الصناديق، والأكياس الورقية، ويُمكن تشغيل الموسيقى بقربها، أو إصدار ضوضاء لجعلها تُحاول السمع والتحرّك والبحث عن مصادر الصوت.\n\n\n"
                 ,R.drawable.cat," نصائح هامة عند التعامل مع القطط");
        Tips t2 = new Tips( "مستشفى بيت الانماء البيطري" ,R.drawable.image,"nhdjdh");

        tips.add(t1);
        tips.add(t2);



        TipsAdapter pa = new TipsAdapter(tips,this.getActivity());
        recyclerView.setAdapter(pa);
        return view;
    }
}