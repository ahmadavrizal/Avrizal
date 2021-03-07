print("Ahmad Avrizal WIdiarso")
print("A11.2019.11851")
print("Praktek Struktur Data")
print("====================================")
q = [] #inisialisasi variabel q

q.append('w') #index 1 
q.append('o') #index 2
q.append('r') #index 3
q.append('l') #index 4
q.append('d') #index 5

def leght():#menampilkan panjang dari list
	return len(q)
def head():#menampilkan index ke 0
	return q[0]
def tail():#menampilkan index terakhir
	return q[len(q)-1]
def is_empty():#Pengecekan list kosong
	return q == []

print("isi List q 		:",q)
print("Panjang List		:",leght())
print("Head dari List q :",head())
print("Tail dari List q :",tail())
print("List Kosong 		:",is_empty())

#Hapus elemen dari Dequeue
q.pop(0)
q.pop(0)
out = q.pop(0)
print("Data yang terhapus 	:",out)
print("Hasil List Sekarang 	:",q)
q.pop(0)
#Jika list kosong di Dequeue maka akan terjadi sebuah eror