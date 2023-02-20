#version 330
out vec4 frag_color;
in vec4 out_color;

// out dilempar keluar, in variable itu artiny berharap dpt lemparan dr vec ke frag
//position variable bisa diubah ubah

void main() {
//    frag_color = uni_color;
    frag_color = out_color;

}