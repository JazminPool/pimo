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

import e.jazmi.pimo.Adapters.Adapter_notas;
import e.jazmi.pimo.Atributos.Atributos_Nota;
import e.jazmi.pimo.Forms.Frm_Add_Nota;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Notas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Notas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Notas extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<Atributos_Nota> list_notas;
    RecyclerView recycler_content_notas;

    public Fragment_Notas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Notas.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Notas newInstance(String param1, String param2) {
        Fragment_Notas fragment = new Fragment_Notas();
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


        View vista = inflater.inflate(R.layout.fragment_fragment__notas, container, false);
        list_notas = new ArrayList<>();
        recycler_content_notas = (RecyclerView) vista.findViewById(R.id.container_recycler_notas_id);

        recycler_content_notas.setLayoutManager(new LinearLayoutManager(getContext()));

        get_notas();

        //invoca el adaptador y le asigna la lista al recycler
        Adapter_notas adapter_notass = new Adapter_notas(list_notas);
        recycler_content_notas.setAdapter(adapter_notass);


        FloatingActionButton fab= vista.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Frm_Add_Nota.class);
                getActivity().startActivity(i);
            }
        });


        return vista;
    }

    //aqui es donde se llena el recycler
    public void get_notas(){
        list_notas.add(new Atributos_Nota("Why do we use it?",
                                          "It is a long established fact that a reader " +
                                                  "will be distracted by the readable content of " +
                                                  "a page when looking at its layout. The point of " +
                                                  "using Lorem Ipsum is that it has a more-or-less " +
                                                  "normal distribution of letters, as opposed to " +
                                                  "using 'Content here, content here', "));
        list_notas.add(new Atributos_Nota("What is Lorem Ipsum?",
                                          "Lorem Ipsum is simply dummy text of the printing and " +
                                                  "typesetting industry. Lorem Ipsum has been the " +
                                                  "industry's standard dummy text ever since the 1500s, " +
                                                  "when an unknown printer took a galley of type and " +
                                                  "scrambled it to make a type specimen book."));
        list_notas.add(new Atributos_Nota("Where does it come from?",
                                          "Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                                                  "In tincidunt lectus at erat finibus ultrices.\n" +
                                                  "Duis consectetur nunc nec accumsan sagittis."));

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
