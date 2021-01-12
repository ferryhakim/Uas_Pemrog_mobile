package com.example.katalogsmarphone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.katalogsmarphone.merek.Hp;

import java.util.List;

public class DaftarHpAdapter extends ArrayAdapter<Hp> {
    Context context;

    public DaftarHpAdapter(@NonNull Context context, @NonNull List<Hp> objects) {
        super(context, R.layout.row_hp, objects);
        this.context = context;
    }

    class ViewHolder {
        TextView txTgl;
        TextView txNilai;
        TextView txDeskripsi;
        TextView txModel;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Hp tr = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_hp, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txTgl = convertView.findViewById(R.id.row_tx_tgl_transaksi);
            viewHolder.txDeskripsi = convertView.findViewById(R.id.row_tx_desc_transaksi);
            viewHolder.txNilai = convertView.findViewById(R.id.row_tx_harga);
            viewHolder.txModel = convertView.findViewById(R.id.row_tx_model);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txTgl.setText(GenericUtility.DATE_FORMAT.format(tr.getTanggal()));
        viewHolder.txDeskripsi.setText(tr.getDeskripsi());
        viewHolder.txModel.setText(tr.getModel());
        if (tr.getJenis().equals(Hp.REALME)) {
            viewHolder.txNilai.setText(tr.getNilai());
            } else {
                viewHolder.txNilai.setText((tr.getNilai()));
            }
            return convertView;
        }
    }
