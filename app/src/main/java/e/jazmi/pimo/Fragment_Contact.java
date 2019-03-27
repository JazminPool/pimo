package e.jazmi.pimo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import e.jazmi.pimo.Adapters.Adapter_directorio;
import e.jazmi.pimo.Adapters.Adapter_recordatorios;
import e.jazmi.pimo.Atributos.Atributos_Directorio;
import e.jazmi.pimo.Dialogs.Dialog_Add_Profesor;
import e.jazmi.pimo.Response.DirectorioResponse;
import e.jazmi.pimo.Services.DirectorioInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Contact.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Contact#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Contact extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<Atributos_Directorio> list_directorios;
    RecyclerView recycler_content_directorio;

    private static final String TAG = "DIRLIST";

    private Adapter_directorio adapter;
    private Retrofit retrofit;


    public Fragment_Contact() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Contact.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Contact newInstance(String param1, String param2) {
        Fragment_Contact fragment = new Fragment_Contact();
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
        View vista = inflater.inflate(R.layout.fragment_fragment__contact, container, false);
        recycler_content_directorio = (RecyclerView) vista.findViewById(R.id.container_recycler_directorio_id);
        adapter = new Adapter_directorio();
        recycler_content_directorio.setAdapter(adapter);

        recycler_content_directorio.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler_content_directorio.setLayoutManager(layoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.137.204:2500/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        get_directorio();
        /**ir a activity*/
        FloatingActionButton fab= vista.findViewById(R.id.fab_add_profe);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_Dialog_add();
            }
        });

        return vista;
    }

    public void open_Dialog_add() {
        Dialog_Add_Profesor add_profe = new Dialog_Add_Profesor();
        add_profe.show(getFragmentManager(), "agregar_profe");
    }

    private void get_directorio() {
        DirectorioInterface service  = retrofit.create(DirectorioInterface.class);
        Call<DirectorioResponse> directorioResponseCall = service.getAll();
        directorioResponseCall.enqueue(new Callback<DirectorioResponse>() {
            @Override
            public void onResponse(Call<DirectorioResponse> call, Response<DirectorioResponse> response) {
                if (response.isSuccessful())
                {
                    DirectorioResponse directorioResponse = response.body();
                    ArrayList<Atributos_Directorio> directorios = directorioResponse.getList();

                    adapter.addDirectorio(directorios);
                    for (int i = 0; i < directorios.size(); i++) {
                        Atributos_Directorio n = directorios.get(i);
                        Log.i(TAG, "Profesor: " + n.getNombre());
                    }
                }else
                {
                    Log.e(TAG,"Onresponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<DirectorioResponse> call, Throwable t) {
            Log.e(TAG,"Onfail: "+t.getMessage());
            }
        });
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
