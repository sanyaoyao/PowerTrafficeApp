package com.example.powertrafficeapp.fragment.lukou;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.powertrafficeapp.R;
import com.example.powertrafficeapp.View.MyTableTextView;
import com.example.powertrafficeapp.util.UrlBean;
import com.example.powertrafficeapp.util.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


/**
 * Created by dell on 2017/08/30.
 */

public class lukou_fragment_3 extends Fragment {
    int ddd;
    int[] arrayw = {1, 2, 3, 4, 5};
    List<String> list;
    ArrayAdapter adapter;
    String urlHost;
    int honglu = 1;
    int d = 0;
    String hong1;
    String huang1;
    String lv1;
    String hong2;
    String huang2;
    String lv2;
    String hong3;
    String huang3;
    String lv3;
    String hong4;
    String huang4;
    String lv4;
    String hong5;
    String huang5;
    String lv5;
    Button button;
    CheckBox check;
    private Button buttonCuo;
    private LinearLayout Ralativeee;
    private UrlBean urlBean;
    private View relativeLayout;
    private String[] name = {"路口", "红灯时长", "黄灯时长", "绿灯时长", "操作项", " 设置 "};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lukou_fragment_3, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Ralativeee = (LinearLayout) getActivity().findViewById(R.id.Ralativeee);
        urlBean = Util.loadSetting(getContext());
        relativeLayout = LayoutInflater.from(getActivity()).inflate(R.layout.table, null);
        MyTableTextView title = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_1);
        title.setText(name[0]);
        title.setTextColor(Color.BLUE);
        title = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_2);
        title.setText(name[1]);
        title.setTextColor(Color.BLUE);
        title = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_3);
        title.setText(name[2]);
        title.setTextColor(Color.BLUE);
        title = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_4);
        title.setText(name[3]);
        title.setTextColor(Color.BLUE);
        title = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_5);
        title.setText(name[4]);
        title.setTextColor(Color.BLUE);
        title = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_6);
        title.setText(name[5]);
        title.setTextColor(Color.BLUE);
        check = (CheckBox) relativeLayout.findViewById(R.id.checkbox);
        check.setVisibility(View.GONE);
        button = (Button) relativeLayout.findViewById(R.id.btn_shezhi);
        button.setVisibility(View.GONE);
        Ralativeee.addView(relativeLayout);
        urlHost = "http://" + urlBean.getUrl() + ":" + urlBean.getPort() + "/transportservice/type/jason/action/GetTrafficLightConfigAction.do";
        JSONObject object = new JSONObject();
        try {
            object.put("TrafficLightId", honglu);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        getAllCarrrValue(urlHost, object);
    }

    private void getAllCarValue(String urlHostAction, JSONObject params) {
        RequestQueue mQueue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, urlHostAction, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stu
                Log.i("TAG volley", response.toString());
                String str = response.toString();
                if (honglu == 1) {
                    try {
                        JSONObject df = new JSONObject(str);
                        String dsd = df.getString("serverinfo");
                        JSONObject dfee = new JSONObject(dsd);
                        String hong = dfee.getString("RedTime");
                        String huang = dfee.getString("YellowTime");
                        String lv = dfee.getString("GreenTime");
                        relativeLayout = LayoutInflater.from(getActivity()).inflate(R.layout.table, null);
                        MyTableTextView txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_1);
                        txt.setText(String.valueOf(1));
                        txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_2);
                        txt.setText(hong);

                        txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_3);
                        txt.setText(huang);
                        txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_4);
                        txt.setText(lv);
                        check = (CheckBox) relativeLayout.findViewById(R.id.checkbox);
                        check.isChecked();
                        button = (Button) relativeLayout.findViewById(R.id.btn_shezhi);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialoge();
                                Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
                            }
                        });
                        button.setText(" 设置 ");
                        Ralativeee.addView(relativeLayout);
                        Log.i("TAG volley", dsd);
                        shujue();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (honglu == 2) {
                    try {
                        JSONObject df = new JSONObject(str);
                        String dsd = df.getString("serverinfo");
                        JSONObject dfee = new JSONObject(dsd);
                        String hong = dfee.getString("RedTime");
                        String huang = dfee.getString("YellowTime");
                        String lv = dfee.getString("GreenTime");
                        relativeLayout = LayoutInflater.from(getActivity()).inflate(R.layout.table, null);
                        MyTableTextView txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_1);
                        txt.setText(String.valueOf(2));
                        txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_2);
                        txt.setText(hong);
                        txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_3);
                        txt.setText(huang);
                        txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_4);
                        txt.setText(lv);
                        check = (CheckBox) relativeLayout.findViewById(R.id.checkbox);
                        check.isChecked();
                        button = (Button) relativeLayout.findViewById(R.id.btn_shezhi);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialoge();
                                Toast.makeText(getActivity(), "2", Toast.LENGTH_SHORT).show();
                            }
                        });
                        button.setText(" 设置 ");
                        Ralativeee.addView(relativeLayout);
                        Log.i("TAG volley", dsd);
                        shujue();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else if (honglu == 3) {
                    try {
                        JSONObject df = new JSONObject(str);
                        String dsd = df.getString("serverinfo");
                        JSONObject dfee = new JSONObject(dsd);
                        String hong = dfee.getString("RedTime");
                        String huang = dfee.getString("YellowTime");
                        String lv = dfee.getString("GreenTime");

                        relativeLayout = LayoutInflater.from(getActivity()).inflate(R.layout.table, null);
                        MyTableTextView txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_1);
                        txt.setText(String.valueOf(3));
                        txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_2);
                        txt.setText(hong);
                        txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_3);
                        txt.setText(huang);
                        txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_4);
                        txt.setText(lv);
                        check = (CheckBox) relativeLayout.findViewById(R.id.checkbox);
                        check.isChecked();
                        button = (Button) relativeLayout.findViewById(R.id.btn_shezhi);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialoge();
                                Toast.makeText(getActivity(), "3", Toast.LENGTH_SHORT).show();
                            }
                        });
                        button.setText(" 设置 ");
                        Ralativeee.addView(relativeLayout);
                        Log.i("TAG volley", dsd);
                        shujue();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else if (honglu == 4) {
                    try {
                        JSONObject df = new JSONObject(str);
                        String dsd = df.getString("serverinfo");
                        JSONObject dfee = new JSONObject(dsd);
                        String hong = dfee.getString("RedTime");
                        String huang = dfee.getString("YellowTime");
                        String lv = dfee.getString("GreenTime");
                        relativeLayout = LayoutInflater.from(getActivity()).inflate(R.layout.table, null);
                        MyTableTextView txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_1);
                        txt.setText(String.valueOf(4));
                        txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_2);
                        txt.setText(hong);
                        txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_3);
                        txt.setText(huang);
                        txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_4);
                        txt.setText(lv);
                        check = (CheckBox) relativeLayout.findViewById(R.id.checkbox);
                        check.isChecked();
                        button = (Button) relativeLayout.findViewById(R.id.btn_shezhi);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialoge();
                                Toast.makeText(getActivity(), "4", Toast.LENGTH_SHORT).show();
                            }
                        });
                        button.setText(" 设置 ");
                        Ralativeee.addView(relativeLayout);
                        Log.i("TAG volley", dsd);
                        shujue();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else if (honglu == 5) {
                    try {
                        JSONObject df = new JSONObject(str);
                        String dsd = df.getString("serverinfo");
                        JSONObject dfee = new JSONObject(dsd);
                        String hong = dfee.getString("RedTime");
                        String huang = dfee.getString("YellowTime");
                        String lv = dfee.getString("GreenTime");

                        relativeLayout = LayoutInflater.from(getActivity()).inflate(R.layout.table, null);
                        MyTableTextView txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_1);
                        txt.setText(String.valueOf(5));
                        txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_2);
                        txt.setText(hong);
                        txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_3);
                        txt.setText(huang);
                        txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_4);
                        txt.setText(lv);
                        check = (CheckBox) relativeLayout.findViewById(R.id.checkbox);
                        check.isChecked();
                        button = (Button) relativeLayout.findViewById(R.id.btn_shezhi);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialoge();
                                Toast.makeText(getActivity(), "5", Toast.LENGTH_SHORT).show();
                            }
                        });
                        button.setText(" 设置 ");
                        Ralativeee.addView(relativeLayout);
                        Log.i("TAG volley", dsd);
                        shujue();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();
                Log.i("TAG volley", error.toString());
            }
        });
        mQueue.add(jsonObjectRequest);
    }

    private void getAllCarrrValue(String urlHostAction, JSONObject params) {
        RequestQueue mQueue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, urlHostAction, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stu
                Log.i("TAG volley", response.toString());
                String str = response.toString();
                if (honglu == 1) {
                    try {
                        JSONObject df = new JSONObject(str);
                        String dsd = df.getString("serverinfo");
                        JSONObject dfee = new JSONObject(dsd);
                        hong1 = dfee.getString("RedTime");
                        huang1 = dfee.getString("YellowTime");
                        lv1 = dfee.getString("GreenTime");
                        shuju();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (honglu == 2) {
                    try {
                        JSONObject df = new JSONObject(str);
                        String dsd = df.getString("serverinfo");
                        JSONObject dfee = new JSONObject(dsd);
                        hong2 = dfee.getString("RedTime");
                        huang2 = dfee.getString("YellowTime");
                        lv2 = dfee.getString("GreenTime");

                        shuju();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (honglu == 3) {
                    try {
                        JSONObject df = new JSONObject(str);
                        String dsd = df.getString("serverinfo");
                        JSONObject dfee = new JSONObject(dsd);
                        hong3 = dfee.getString("RedTime");
                        huang3 = dfee.getString("YellowTime");
                        lv3 = dfee.getString("GreenTime");
                        shuju();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (honglu == 4) {
                    try {
                        JSONObject df = new JSONObject(str);
                        String dsd = df.getString("serverinfo");
                        JSONObject dfee = new JSONObject(dsd);
                        hong4 = dfee.getString("RedTime");
                        huang4 = dfee.getString("YellowTime");
                        lv4 = dfee.getString("GreenTime");
                        shuju();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (honglu == 5) {
                    try {
                        JSONObject df = new JSONObject(str);
                        String dsd = df.getString("serverinfo");
                        JSONObject dfee = new JSONObject(dsd);
                        hong5 = dfee.getString("RedTime");
                        huang5 = dfee.getString("YellowTime");
                        lv5 = dfee.getString("GreenTime");
                        int s1 = Integer.parseInt(lv1);
                        int s2 = Integer.parseInt(lv2);
                        int s3 = Integer.parseInt(lv3);
                        int s4 = Integer.parseInt(lv4);
                        int s5 = Integer.parseInt(lv5);
                        int[] array = {s1, s2, s3, s4, s5};
                        for (int e = 0; e < (array.length - 1); e++) {
                            for (int j = e + 1; j < array.length; j++) {
                                if (array[e] > array[j]) {
                                    int zhong = array[e];
                                    array[e] = array[j];
                                    array[j] = zhong;
                                    int hong = arrayw[e];
                                    arrayw[e] = arrayw[j];
                                    arrayw[j] = hong;
                                }
                            }
                        }
                        urlBean = Util.loadSetting(getContext());
                        urlHost = "http://" + urlBean.getUrl() + ":" + urlBean.getPort() + "/transportservice/type/jason/action/GetTrafficLightConfigAction.do";
                        JSONObject object = new JSONObject();
                        try {
                            object.put("TrafficLightId", arrayw[0]);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        honglu = arrayw[0];
                        Log.i("dasdsssss", String.valueOf(object));
                        Log.i("asdasdkkkk", String.valueOf(arrayw[0]) + "#" + String.valueOf(arrayw[1]) + "#" + String.valueOf(arrayw[2])
                                + "#" + String.valueOf(arrayw[3]) + "#" + String.valueOf(arrayw[4]));
                        Log.i("asdasdkkkk", String.valueOf(array[0]) + "#" + String.valueOf(array[1]) + "#" + String.valueOf(array[2]) + "#"
                                + String.valueOf(array[3]) + "#" + String.valueOf(array[4]));
                        getAllCarValue(urlHost, object);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();
                Log.i("TAG volley", error.toString());
            }
        });
        mQueue.add(jsonObjectRequest);
    }

    public void shuju() {
        honglu++;
        urlBean = Util.loadSetting(getContext());
        urlHost = "http://" + urlBean.getUrl() + ":" + urlBean.getPort() + "/transportservice/type/jason/action/GetTrafficLightConfigAction.do";
        JSONObject object = new JSONObject();
        try {
            object.put("TrafficLightId", honglu);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i("dasds", String.valueOf(object));
        getAllCarrrValue(urlHost, object);
    }

    public void shujue() {
        d++;
        if (d <= 4) {
            urlBean = Util.loadSetting(getContext());
            urlHost = "http://" + urlBean.getUrl() + ":" + urlBean.getPort() + "/transportservice/type/jason/action/GetTrafficLightConfigAction.do";
            JSONObject object = new JSONObject();
            try {
                object.put("TrafficLightId", arrayw[d]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            honglu = arrayw[d];
            Log.i("dasdssssss", String.valueOf(honglu));
            Log.i("dasdsss", String.valueOf(object));

            getAllCarValue(urlHost, object);
        } else {
            return;
        }

    }

    public void dialoge() {
        final Dialog dialoge = new Dialog(getActivity());
        Log.i("TAG volley", "sdfsdfsdfsdfsdfsdfs");
        dialoge.setTitle("查询结果");
        dialoge.getWindow().setContentView(R.layout.dialog_sdf_f3);
        buttonCuo = (Button) dialoge.getWindow().findViewById(R.id.button_cuo);
        buttonCuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialoge.dismiss();

            }
        });
        dialoge.show();

    }
}
