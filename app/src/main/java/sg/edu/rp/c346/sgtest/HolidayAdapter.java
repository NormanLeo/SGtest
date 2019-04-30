package sg.edu.rp.c346.sgtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {

    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvDay;
    private TextView tvDate;
    private ImageView ivProg;


    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        holiday = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_row, parent, false);

        tvDate = rowView.findViewById(R.id.tvDate);
        tvDay = rowView.findViewById(R.id.tvDay);
        ivProg = rowView.findViewById(R.id.ivProg);

        Holiday currentFood = holiday.get(position);

        tvDay.setText(currentFood.getDay());
        tvDate.setText(currentFood.getDate());

        if(currentFood.getType().equals("Secular")) {
            if(currentFood.isPh()) {
                ivProg.setImageResource(R.drawable.new_year);
            } else {
                ivProg.setImageResource(R.drawable.labour_day);
            }
        }
        else {
            if(currentFood.isPh()) {
                ivProg.setImageResource(R.drawable.cny);
            } else {
                ivProg.setImageResource(R.drawable.good_friday);
            }
        }

        return rowView;
    }




}
