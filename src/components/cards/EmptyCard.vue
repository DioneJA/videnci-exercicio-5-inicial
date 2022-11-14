<template>
  <div class="q-pa-md row items-start q-gutter-md flex flex-center">
      <q-card  class="my-card bg-blue-grey-10 text-white">
        <q-card-section class="row flex flex-center">
          <q-avatar
            icon="warning"
            style="font-size: 40px"
            color="orange"
            text-color="white"
            class="q-mr-sm"
          />
          <span class="text-h5">
          <slot></slot>
          </span>
        </q-card-section>
      </q-card>
  </div>
</template>

<script>
</script>

<style lang="scss" scoped>

</style>
