#version 330
out vec4 frag_color;
uniform vec4 uni_color;
// out dilempar keluar, in variable itu artiny berharap dpt lemparan dr vec ke frag
//position variable bisa diubah ubah

void main() {
    //untuk segitiga
//    vec4(red,green,blue,alpha)
//    rgba -> red 100/255
//    fragColor = vec4(1.0,0.0,0.0,1.0);
//    untuk segitiga warna campur
    frag_color = uni_color;
}