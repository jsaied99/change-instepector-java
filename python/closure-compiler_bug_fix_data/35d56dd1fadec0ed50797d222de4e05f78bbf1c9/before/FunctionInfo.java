// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: third_party/java_src/jscomp/java/com/google/javascript/jscomp/function_info.proto

package com.google.javascript.jscomp;

public final class FunctionInfo {
  private FunctionInfo() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_jscomp_FunctionInformationMap_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_jscomp_FunctionInformationMap_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_jscomp_FunctionInformationMap_Entry_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_jscomp_FunctionInformationMap_Entry_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_jscomp_FunctionInformationMap_Module_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_jscomp_FunctionInformationMap_Module_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\nQthird_party/java_src/jscomp/java/com/g" +
      "oogle/javascript/jscomp/function_info.pr" +
      "oto\022\006jscomp\"\277\002\n\026FunctionInformationMap\0223" +
      "\n\005entry\030\001 \003(\n2$.jscomp.FunctionInformati" +
      "onMap.Entry\0225\n\006module\030e \003(\n2%.jscomp.Fun" +
      "ctionInformationMap.Module\032\207\001\n\005Entry\022\n\n\002" +
      "id\030\002 \002(\005\022\023\n\013source_name\030\003 \002(\t\022\023\n\013line_nu" +
      "mber\030\004 \002(\005\022\023\n\013module_name\030\005 \002(\t\022\014\n\004size\030" +
      "\006 \002(\005\022\014\n\004name\030\007 \002(\t\022\027\n\017compiled_source\030\010" +
      " \002(\t\032/\n\006Module\022\014\n\004name\030f \002(\t\022\027\n\017compiled",
      "_source\030g \002(\tB \n\034com.google.javascript.j" +
      "scompP\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_jscomp_FunctionInformationMap_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_jscomp_FunctionInformationMap_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_jscomp_FunctionInformationMap_descriptor,
              new java.lang.String[] { "Entry", "Module", },
              com.google.javascript.jscomp.FunctionInformationMap.class,
              com.google.javascript.jscomp.FunctionInformationMap.Builder.class);
          internal_static_jscomp_FunctionInformationMap_Entry_descriptor =
            internal_static_jscomp_FunctionInformationMap_descriptor.getNestedTypes().get(0);
          internal_static_jscomp_FunctionInformationMap_Entry_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_jscomp_FunctionInformationMap_Entry_descriptor,
              new java.lang.String[] { "Id", "SourceName", "LineNumber", "ModuleName", "Size", "Name", "CompiledSource", },
              com.google.javascript.jscomp.FunctionInformationMap.Entry.class,
              com.google.javascript.jscomp.FunctionInformationMap.Entry.Builder.class);
          internal_static_jscomp_FunctionInformationMap_Module_descriptor =
            internal_static_jscomp_FunctionInformationMap_descriptor.getNestedTypes().get(1);
          internal_static_jscomp_FunctionInformationMap_Module_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_jscomp_FunctionInformationMap_Module_descriptor,
              new java.lang.String[] { "Name", "CompiledSource", },
              com.google.javascript.jscomp.FunctionInformationMap.Module.class,
              com.google.javascript.jscomp.FunctionInformationMap.Module.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  public static void internalForceInit() {}
  
  // @@protoc_insertion_point(outer_class_scope)
}