package application2email.co.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import application2email.co.Emails;
import application2email.co.R;

public class Usuarioadapter extends RecyclerView.Adapter<Usuarioadapter.ViewHolder> {

    private List<Emails> Emailslist;
    private Context context;

    public Usuarioadapter(List<Emails> emailslist, Context context) {
        Emailslist = emailslist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email,parent, false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtAsunto.setText(Emailslist.get(position).getsubject());
        holder.txtRemitente.setText(Emailslist.get(position).getremitente());
        holder.txtDate.setText(Emailslist.get(position).getdate());
        Glide.with(context)
                .load(Emailslist.get(position).getfoto())
                .centerCrop()
                .into(holder.imgusuario);



    }

    @Override
    public int getItemCount() {
        return  Emailslist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgusuario;
        private TextView txtAsunto;
        private TextView txtRemitente;
        private TextView txtDate;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgusuario = itemView.findViewById(R.id.img_usuario);
            txtAsunto = itemView.findViewById(R.id.txt_subject);
            txtRemitente = itemView.findViewById(R.id.txt_remitente);
            txtDate = itemView.findViewById(R.id.txt_date);

            //Enlazar elementos
        }
    }
}
