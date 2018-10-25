package com.example.user.lab6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list);

        Data[] transData = new Data[4];
        for (int i = 0; i <transData.length; i++)
        {
            transData[i] = new Data();
        }
        transData[0].name = "腳踏車";
        transData[1].name = "機車";
        transData[2].name = "汽車";
        transData[3].name = "巴士";
        transData[0].photo = R.drawable.trans1;
        transData[1].photo = R.drawable.trans2;
        transData[2].photo = R.drawable.trans3;
        transData[3].photo = R.drawable.trans4;

        myAdapter transAdapter = new myAdapter(transData,
                R.layout.tran_list);
        Spinner spinner = (Spinner) findViewById(R.id.spin);
        spinner.setAdapter(transAdapter);

        Data[] cubee = new Data[10];
        for (int i = 0; i < cubee.length; i++)
        {
            cubee[i] = new Data();
        }
        cubee[0].name = "哭哭";
        cubee[1].name = "發抖";
        cubee[2].name = "再見";
        cubee[3].name = "生氣";
        cubee[4].name = "昏倒";
        cubee[5].name = "竊笑";
        cubee[6].name = "很棒";
        cubee[7].name = "你好";
        cubee[8].name = "驚嚇";
        cubee[9].name = "大笑";
        cubee[0].photo = R.drawable.cubee1;
        cubee[1].photo = R.drawable.cubee2;
        cubee[2].photo = R.drawable.cubee3;
        cubee[3].photo = R.drawable.cubee4;
        cubee[4].photo = R.drawable.cubee5;
        cubee[5].photo = R.drawable.cubee6;
        cubee[6].photo = R.drawable.cubee7;
        cubee[7].photo = R.drawable.cubee8;
        cubee[8].photo = R.drawable.cubee9;
        cubee[9].photo = R.drawable.cubee10;
        myAdapter cubeea = new myAdapter(cubee,
                R.layout.cubee_list);

        GridView gridView = (GridView) findViewById(R.id.grid);

        gridView.setAdapter(cubeea);

        String[] messageData = new String[]{"訊息1", "訊息2","訊息3","訊息4","訊息5","訊息6"};

        ArrayAdapter<String> messageAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, messageData);

        listView.setAdapter(messageAdapter);
    }

    class Data
    {
        int photo; String name;
    }

    public class myAdapter extends BaseAdapter
    {
        private Data[] data;
        private int view;

        public myAdapter(Data[] data, int view)
        {
            this.data = data; this.view = view;
        }

        @Override
        public int getCount(){return data.length; }

        @Override
        public Data getItem(int position){return data[position]; }

        @Override
        public  long getItemId(int position){return 0;}

        @Override
        public View getView(int position, View rowView, ViewGroup parent)
        {
            rowView = getLayoutInflater().inflate(view, parent, false);

            TextView name = (TextView) rowView.findViewById(R.id.name);
            ImageView fig = (ImageView) rowView.findViewById(R.id.fig);

            name.setText(data[position].name);
            fig.setImageResource(data[position].photo);
            return rowView;
        }
    }
}
