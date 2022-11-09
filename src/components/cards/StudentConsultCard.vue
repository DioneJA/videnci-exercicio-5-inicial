<template>
      <q-card
        class="my-card bg-blue-grey-10 text-white column flex flex-center"
        style="max-width: 650px"
      >
        <q-card-section>
          <div class="text-h6"><strong>ID: </strong>{{ student.id }}</div>
          <div class="text-subtitle1">
            <strong>Nome: </strong>{{ student.name }}
          </div>
          <div class="testTrue" v-if="student.amountTests > 0">
            <div class="text-subtitle1">
              <strong>Média: </strong>{{ student.average.toFixed(2) }}
            </div>
            <div class="text-subtitle1">
              <strong>Menor nota: </strong>{{ student.lowestGrade }}
            </div>
            <div class="text-subtitle1">
              <strong>Maior nota: </strong>{{ student.highestGrade }}
            </div>
            <div class="text-subtitle1">
              <strong>Quantidade de provas realizadas: </strong
              >{{ student.amountTests }}
            </div>
          </div>
          <div class="testFalse" v-else>
            <div class="text-subtitle1">
              <strong>O Aluno não possui nenhuma prova cadastrada!</strong>
            </div>
          </div>
          <test-card :id="id"></test-card>
        </q-card-section>
        <btn-add-test :student="student"/>
      </q-card>
</template>

<script>
import BtnAddTest from '../buttons/BtnAddTest.vue'
import TestCard from '../cards/TestCard.vue'
export default {
  components: {
    BtnAddTest, TestCard
  },
  props: {
    id: {
      type: String,
      required: true
    }
  },
  data () {
    return {
      student: {
        type: Object,
        required: true
      }
    }
  },
  created () {
    this.consultStudent()
  },
  methods: {
    consultStudent () {
      this.$axios
        .get('/student/' + this.id)
        .then((resp) => {
          this.student = resp.data
        })
        .catch((err) => {
          console.log(err)
        })
    }
  }
}
</script>

<style lang="scss" scoped>

</style>
