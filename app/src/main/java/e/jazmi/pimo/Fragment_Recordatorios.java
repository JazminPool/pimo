package e.jazmi.pimo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import e.jazmi.pimo.Adapters.Adapter_recordatorios;
import e.jazmi.pimo.Atributos.Atributos_Recordatorios;
import e.jazmi.pimo.Forms.Frm_Add_Recordatorio;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Recordatorios.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Recordatorios#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Recordatorios extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<Atributos_Recordatorios> list_recordatorios;
    RecyclerView recycler_content_recordatorio;


    public Fragment_Recordatorios() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Recordatorios.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Recordatorios newInstance(String param1, String param2) {
        Fragment_Recordatorios fragment = new Fragment_Recordatorios();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_fragment__recordatorios, container, false);
        list_recordatorios = new ArrayList<>();
        recycler_content_recordatorio = (RecyclerView) vista.findViewById(R.id.container_recycler_recordatorios_id);
        recycler_content_recordatorio.setLayoutManager(new LinearLayoutManager(getContext()));

        get_recordatorios();

        Adapter_recordatorios adapter_recordatorios = new Adapter_recordatorios(list_recordatorios);
        recycler_content_recordatorio.setAdapter(adapter_recordatorios);

        /**ir a activity*/
        FloatingActionButton fab= vista.findViewById(R.id.fab_recordatorios);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Frm_Add_Recordatorio.class);
                getActivity().startActivity(i);
            }
        });



        return vista;
    }

    //aqui es donde se llena el recycler
    public void get_recordatorios(){
        list_recordatorios.add(new Atributos_Recordatorios("Titleee", "Hora: 07:00:00 am", "Fecha: 02-02-2019", "micomentario"));
        list_recordatorios.add(new Atributos_Recordatorios("Titleee", "Hora: 07:00:00 am", "Fecha: 02-02-2019", "micomentario"));
        list_recordatorios.add(new Atributos_Recordatorios("Titleee", "Hora: 07:00:00 am", "Fecha: 02-02-2019", "micomentario"));
        list_recordatorios.add(new Atributos_Recordatorios("Titleee", "Hora: 07:00:00 am", "Fecha: 02-02-2019", "micomentario"));
        list_recordatorios.add(new Atributos_Recordatorios("Titleee", "Hora: 07:00:00 am", "Fecha: 02-02-2019", "micomentario"));

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
