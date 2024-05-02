package com.proyectoProgramacion;

import androidx.recyclerview.widget.RecyclerView;

public class EmpleadoAdapter extends RecyclerView.Adapter<EmpleadoAdapter.ViewHolder> {

    private List<Empleado> listaEmpleados;

    public EmpleadoAdapter(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empleado, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Empleado empleado = listaEmpleados.get(position);
        // Aquí puedes usar Glide o Picasso para cargar la imagen
        Glide.with(holder.itemView.getContext()).load(empleado.getUrlFotoPerfil()).into(holder.fotoPerfil);
    }

    @Override
    public int getItemCount() {
        return listaEmpleados.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView fotoPerfil;

        public ViewHolder(View itemView) {
            super(itemView);
            fotoPerfil = itemView.findViewById(R.id.fotoPerfil);
        }
    }
}
