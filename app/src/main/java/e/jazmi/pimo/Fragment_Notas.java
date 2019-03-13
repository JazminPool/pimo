package e.jazmi.pimo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import e.jazmi.pimo.Adapters.Adapter_notas;
import e.jazmi.pimo.Adapters.ExampleNotas;
import e.jazmi.pimo.Atributos.Atributos_Nota;
import e.jazmi.pimo.Forms.Frm_Add_Nota;
import e.jazmi.pimo.Services.APIClient;
import e.jazmi.pimo.Services.NotasService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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

        NotasService notaService = APIClient.getClient().create(NotasService.class);
        Call call = notaService.findAll();

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                list_notas.add (new Atributos_Nota());
                recycler_content_notas.setAdapter(new Adapter_notas(list_notas));
                String res = (String) response.body();
                Log.d("esta aqui",res);
                list_notas.add(new Atributos_Nota(response.body().titulo,"mi nota fragmet 1"));

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getContext(),"Fallido", Toast.LENGTH_SHORT).show();
            }

        });
        /*list_notas.add(new Atributos_Nota("Nota 01","mi nota fragmet fragmet fragmet fragmet fragmet fragmet fragmet fragmet"));
        list_notas.add(new Atributos_Nota("dasdad","mi nota fragmet 1"));
        list_notas.add(new Atributos_Nota("dasda","mi nota fragmet 1"));
        list_notas.add(new Atributos_Nota("26/02","mi nota fragmet 1"));
        list_notas.add(new Atributos_Nota("lhdsiakbja","mi nota fragmet 1"));
        list_notas.add(new Atributos_Nota("what","mi nota fragmet 1"));
        list_notas.add(new Atributos_Nota("pruebaxd","mi nota fragmet 1"));*/
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
