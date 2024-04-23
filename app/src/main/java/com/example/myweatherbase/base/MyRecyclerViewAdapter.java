package com.example.myweatherbase.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private Root temporal;
    private Context context;
    private LayoutInflater layoutInflater;
    private int layout;
    private View.OnClickListener listener;

    public MyRecyclerViewAdapter(Root temporal, Context context) {
        super();
        this.temporal = temporal;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(layout,parent,false);
        view.setOnClickListener(listener);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Root.List list = temporal.list.get(position);
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + list.weather.get(0).icon + Parameters.ICON_URL_POST, holder.ivIcono);


        holder.tvDescripcion.setText(list.weather.get(0).description);
        Date date = new Date((long)list.dt*1000);
        double temp = list.main.temp;
        double maxTemp = list.main.temp_max;
        double minTemp = list.main.temp_min;
        SimpleDateFormat dateDayOfWeek = new SimpleDateFormat("E");
        SimpleDateFormat dateDay = new SimpleDateFormat("d/MM/yyyy");
        SimpleDateFormat dateHour = new SimpleDateFormat("HH:mm");
        holder.tvDay.setText(dateDay.format(date));
        holder.tvDayOfWeek.setText(dateDayOfWeek.format(date));
        holder.tvHora.setText(dateHour.format(date));
        holder.tvTemp.setText("Temp "+String.valueOf(temp)+"º");
        holder.tvTempMax.setText("Max "+String.valueOf(maxTemp)+"º");
        holder.tvTempMin.setText("Min "+String.valueOf(minTemp)+"º");

    }


    @Override
    public int getItemCount() {
        return temporal.list.size();
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public Root.List getList(int position){
        return temporal.list.get(position);
    }


}

class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView ivIcono;
    TextView tvDescripcion;
    TextView tvDay;
    TextView tvDayOfWeek;
    TextView tvHora;
    TextView tvTemp;
    TextView tvTempMax;
    TextView tvTempMin;
    ConstraintLayout clItem;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        ivIcono = itemView.findViewById(R.id.ivIcon);
        tvDescripcion = itemView.findViewById(R.id.tvDescription);
        tvDay = itemView.findViewById(R.id.tvDay);
        tvHora = itemView.findViewById(R.id.tvHora);
        tvDayOfWeek = itemView.findViewById(R.id.tvDayOfWeek);
        tvTemp = itemView.findViewById(R.id.tvTemp);
        tvTempMax = itemView.findViewById(R.id.tvTempMax);
        tvTempMin = itemView.findViewById(R.id.tvTempMin);
        clItem = itemView.findViewById(R.id.clItem);
    }
}